package com.sebnsab.demo.repository;

import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.service.DevBootStrap;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;

//@ActiveProfiles("test")
//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@Import({DevBootStrap.class})
public class ProductRepositoryTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private DetailBiDirectionalRepository detailBiDirectionalRepository;

    @MockBean
    private DetailUniDirectionalRepository detailUniDirectionalRepository;

    @Autowired
    private DevBootStrap devBootStrap;

    @Test
    public void addTest() {


        Mockito.when(transactionRepository.getById(Mockito.anyLong())).thenReturn(new Transaction());

        devBootStrap.initializeData();
        Product p1 = new Product();
        p1.setProductName("test");
        p1.setDateCreated(Date.valueOf(LocalDate.now()));
        p1.setDateModified(p1.getDateCreated());

        p1 = productRepository.save(p1);

        System.out.println(p1.getId());

    }
}
