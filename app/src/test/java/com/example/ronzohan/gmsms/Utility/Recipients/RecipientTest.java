package com.example.ronzohan.gmsms.Utility.Recipients;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecipientTest {
    Recipient recipient;

    @Before
    public void setUp() throws Exception{
        recipient = new Recipient("Ron Daryl Magno", "09169777569");
    }

    @Test
    public void shouldReturnValues() throws Exception {
        assertEquals(recipient.getContactNo(), "09169777569");
        assertEquals(recipient.getName(), "Ron Daryl Magno");
    }

    @Test
    public void shouldReturnBlankValues() throws Exception {
        assertEquals(recipient.getAddress(), "");
    }
}
