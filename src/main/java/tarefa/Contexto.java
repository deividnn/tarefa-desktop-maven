/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Deivid
 */
public class Contexto {

    static Scheduler sh = null;

    public void iniciarAgente() {

        try {
            JobKey jobKeyA = new JobKey("jobA", "group1");
            JobDetail jobA = JobBuilder.newJob(Tarefa.class)
                    .withIdentity(jobKeyA).build();

            Trigger trigger1 = TriggerBuilder
                    .newTrigger()
                    .withIdentity("dummyTriggerName1", "group1")
                    .withSchedule(
                            CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                    .startNow()
                    .build();

            sh = new StdSchedulerFactory().getScheduler();

            sh.start();
            sh.scheduleJob(jobA, trigger1);
            System.out.println("iniciou o agente");
        } catch (Exception e) {
            System.out.println("erro " + e);
        }

    }
}
