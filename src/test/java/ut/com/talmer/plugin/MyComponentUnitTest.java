package ut.com.talmer.plugin;

import org.junit.Test;
import com.talmer.plugin.api.MyPluginComponent;
import com.talmer.plugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}