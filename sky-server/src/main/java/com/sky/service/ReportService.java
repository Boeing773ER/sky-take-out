package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {
    TurnoverReportVO getTurnoverStatistics (LocalDate begin, LocalDate end);

    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    OrderReportVO orderStatistics(LocalDate begin, LocalDate end);

    SalesTop10ReportVO getOrdersStatistics(LocalDate begin, LocalDate end);
}
