/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa;

import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Deivid
 */
public class Tarefa implements Job {

    static List<String> lista;
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        metodos();
    }

    public void metodos() {
        try {
            System.out.println("executando tarefa");
            int i = 0;
            while (i < 1000) {
               System.out.println("procesando" +i);
               i++;
            }
            
            System.out.println("tarefa finalizada");
            Contexto.sh.standby();
            System.out.println("agente pausado");
        } catch (Exception e) {
            System.out.println("erro "+e);
        }

    }

}
