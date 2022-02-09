package com.example.geekbang.spring.class20.example2;

import com.example.geekbang.spring.class20.example2.dbcontrol.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：多数据源间切换之谜
 * @author: gao wei
 * @create: 2022-02-09 14:46
 */

@Service
public class C20E2CardService {
    @Autowired
    private C20E2CardMapper C20E2CardMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DataSource(DataSource.card)
    public void createCard(int studentId) throws Exception {
        C20E2Card card = new C20E2Card();
        card.setStudentId(studentId);
        card.setBalance(50);
        C20E2CardMapper.saveCard(card);
    }
}
