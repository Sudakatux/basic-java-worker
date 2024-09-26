package org.example;

import com.netflix.conductor.sdk.workflow.executor.WorkflowExecutor;
import com.netflix.conductor.sdk.workflow.task.InputParam;
import com.netflix.conductor.sdk.workflow.task.WorkerTask;
import io.orkes.conductor.client.ApiClient;
import io.orkes.conductor.client.OrkesClients;

public class Main {
    public static void main(String[] args) {

        var keyId = "someKey";
        var keySecret = "someSecret";
        var conductorUrl = "conductorUrl";
        ApiClient apiClient = new ApiClient(conductorUrl, keyId, keySecret);
        OrkesClients oc = new OrkesClients(apiClient);

        WorkflowExecutor executor = new WorkflowExecutor(
                oc.getTaskClient(),
                oc.getWorkflowClient(),
                oc.getMetadataClient(),
                10);

        executor.initWorkers("org.example");
    }

    @WorkerTask("greet")
    public String greet(@InputParam("name") String name) {
        return "Hello " + name;
    }
}