package com.microsoft.azure.management.compute;

import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class ComputeUsageOperationsTests extends ComputeManagementTestBase {
    @BeforeClass
    public static void setup() throws Exception {
        createClients();
    }

    @AfterClass
    public static void cleanup() throws Exception {
    }

    @Test
    public void canListComputeUsages() throws Exception {
        List<ComputeUsage> usages = computeManager.usages().listByRegion(Region.US_EAST);
        Assert.assertTrue(usages.size() > 0);
    }
}
