/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.servicemix.examples.camel.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBeanH2 {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseBeanH2.class);

    public DatabaseBeanH2(){}

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create() throws SQLException{
        Statement sta = dataSource.getConnection().createStatement();
        try {
            sta.executeUpdate("CREATE TABLE orders ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, item VARCHAR(50), amount INT, description VARCHAR(300), processed BOOLEAN, consumed BOOLEAN);");
        } catch (SQLException e) {
            LOGGER.info("Table orders already exists");
        }
    }

    public void destroy() throws SQLException {
        dataSource.getConnection().close();
    }


}