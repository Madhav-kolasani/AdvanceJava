 package com.advancedJava.Junit;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserNotifyTest {

    @Mock
    NotificationService uns;

    @InjectMocks
    UserNotify userns;

    @Test
    void shouldSendWelcomeNotification() {

        // This line is OPTIONAL (void methods do nothing by default)
        doNothing().when(uns).sendNotification(anyString());

        userns.registerUser("Mad");

        verify(uns, times(1))
                .sendNotification("Welcome my bro!!");
    }
}
