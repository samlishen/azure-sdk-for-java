/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An error encountered by the Batch service when scheduling a job.
 */
public class JobSchedulingError {
    /**
     * The category of the job scheduling error.
     * Possible values include: 'usererror', 'servererror', 'unmapped'.
     */
    @JsonProperty(required = true)
    private SchedulingErrorCategory category;

    /**
     * An identifier for the job scheduling error. Codes are invariant and are
     * intended to be consumed programmatically.
     */
    private String code;

    /**
     * A message describing the job scheduling error, intended to be suitable
     * for display in a user interface.
     */
    private String message;

    /**
     * A list of additional error details related to the scheduling error.
     */
    private List<NameValuePair> details;

    /**
     * Get the category value.
     *
     * @return the category value
     */
    public SchedulingErrorCategory category() {
        return this.category;
    }

    /**
     * Set the category value.
     *
     * @param category the category value to set
     * @return the JobSchedulingError object itself.
     */
    public JobSchedulingError withCategory(SchedulingErrorCategory category) {
        this.category = category;
        return this;
    }

    /**
     * Get the code value.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the code value.
     *
     * @param code the code value to set
     * @return the JobSchedulingError object itself.
     */
    public JobSchedulingError withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message value.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message value.
     *
     * @param message the message value to set
     * @return the JobSchedulingError object itself.
     */
    public JobSchedulingError withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the details value.
     *
     * @return the details value
     */
    public List<NameValuePair> details() {
        return this.details;
    }

    /**
     * Set the details value.
     *
     * @param details the details value to set
     * @return the JobSchedulingError object itself.
     */
    public JobSchedulingError withDetails(List<NameValuePair> details) {
        this.details = details;
        return this;
    }

}
