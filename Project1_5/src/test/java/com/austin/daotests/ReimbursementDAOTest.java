package com.austin.daotests;

import org.junit.jupiter.api.*;

import com.austin.projectOne.dao.ReimbursementDAO;
import com.austin.projectOne.model.Reimbursement;

import java.sql.Date;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReimbursementDAOTest
{
    private static ReimbursementDAO rdao = ReimbursementDAO.getRdao();

    @Test
    @Order(1)
    void createReimbursement()
    {
        Reimbursement r;
        r = new Reimbursement(
              "Clothes",
              40.00,
              "pending"
                );

        Reimbursement result = rdao.save(r);

        Assertions.assertNotEquals(0, result.getId());

        System.out.println(result);
    }

    @Test
    @Order(2)
    void getReimbursementById()
    {
        List<Reimbursement> reimbursements = rdao.findAll();
        Reimbursement result = rdao.findById(reimbursements.get(reimbursements.size()-1).getId());
        Assertions.assertEquals(40.0, result.getAmount());
    }

    @Test
    @Order(4)
    void getAllReimbursement()
    {
        List<Reimbursement> reimbursements = rdao.findAll();
        Assertions.assertNotEquals(0, reimbursements.size());
    }

    @Test
    @Order(5)
    void updateReimbursement()
    {
        List<Reimbursement> reimbursements = rdao.findAll();
        Reimbursement updateMe = rdao.findById(reimbursements.get(reimbursements.size()-1).getId());
        updateMe.setAmount(400.0);
        Reimbursement result = rdao.save(updateMe);

        Assertions.assertEquals(400.0, result.getAmount());
    }

    @Test
    @Order(6)
    void deleteReimbursement()
    {
        List<Reimbursement> reimbursements = rdao.findAll();
        Reimbursement deleteMe = rdao.findById(reimbursements.get(reimbursements.size()-1).getId());

        boolean result = rdao.delete(deleteMe.getId());

        Assertions.assertEquals(true, result);

    }
}