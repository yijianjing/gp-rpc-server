package com.gupaoedu.ssivp.server.impl;

import com.gupaoedu.ssivp.server.IOrderService;
import com.gupaoedu.ssivp.server.annotion.GpRemoteService;

@GpRemoteService
public class OrderServiceImpl implements IOrderService {
    @Override
    public String queryOrderList() {
        return "queryOrderList";
    }
}
