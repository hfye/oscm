/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2018
 *                                                                              
 *  Author: tokoda                                                      
 *                                                                              
 *  Creation Date: Oct 13, 2011                                                      
 *                                                                              
 *  Completion Time: Oct 13, 2011                                               
 *                                                                              
 *******************************************************************************/

package org.oscm.operationslog;

import org.oscm.types.enumtypes.LogMessageIdentifier;

/**
 * 
 * @author tokoda
 * 
 */
public class TechnicalServiceOperationQuery extends UserOperationLogQuery {

    private static final String TSERVICE_OPERATION = "";

    private static final String[] fieldNames = new String[] {
            COMMON_COLUMN_MODDATE, "op", "user", COMMON_COLUMN_OBJVERSION,
            "service", "provider", "id", "op", "url", "type" };

    @Override
    public LogMessageIdentifier getLogMessageIdentifier() {
        return LogMessageIdentifier.INFO_OPERATION_LOG_TSERVICE_OPERATION;
    }

    @Override
    public String getQuery() {
        return TSERVICE_OPERATION;
    }

    @Override
    public String[] getFieldNames() {
        return fieldNames;
    }

    @Override
    public String getLogType() {
        return "TSERVICE_OPERATION";
    }
}
