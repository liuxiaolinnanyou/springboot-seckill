package com.njupt.service;

import com.njupt.dto.Exposer;
import com.njupt.dto.SeckillExecution;
import com.njupt.entity.Seckill;
import com.njupt.exception.RepeatKillException;
import com.njupt.exception.SeckillCloseException;
import com.njupt.exception.SeckillException;

import java.math.BigDecimal;
import java.util.List;

public interface SeckillService {
    /**
     * 获取所有的秒杀商品列表
     * @return
     */
    List<Seckill> findAll();

    /**
     * 获取某一条商品秒杀信息
     * @param seckillId
     * @return
     */
    Seckill findById(long seckillId);

    /**
     * 秒杀开始时输出暴露秒杀的地址
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀的操作
     * @param seckillId
     * @param money
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution executeSeckill(long seckillId, BigDecimal money, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;
}
