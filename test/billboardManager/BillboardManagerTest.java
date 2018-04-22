package billboardManager;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class BillboardManagerTest {

    @Test
    public void scrollLeftShouldNotifySubscribersWhenCalled() {
        //Arrange
        BillboardManager manager = new BillboardManager(10);
        BillboardObserverInterface mockedObserver = mock(BillboardObserverInterface.class);

        manager.setHours(12);
        manager.setMinutes(30);
        manager.setMessage("This is a test message.");

        manager.subscribe(mockedObserver);

        //Act
        manager.scrollLeft(1);

        //Assert
        verify(mockedObserver, times(1)).updateDisplay(manager);

    }

}