/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.beans;

import ejb.domain.Item;
import ejb.interceptor.AcessoItensInterceptor;
import ejb.interceptor.LogInterceptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

@Stateful
@Interceptors(LogInterceptor.class)
public class MeuBean implements MeuBeanRemote {

    private List<Item> items;

    @PostConstruct
    public void init() {
        items = new ArrayList<Item>();
    }

    @PreDestroy
    public void releaseResources() {
        items.clear();
        items = null;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    @Interceptors(AcessoItensInterceptor.class)
    public Collection<Item> getItems() {
        return items;
    }
}
