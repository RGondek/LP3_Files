/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AcessoItensInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        System.out.println("Acesso Itens: " + context.getMethod());
        return context.proceed();
    }
}
