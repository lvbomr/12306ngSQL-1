/*
 * Copyright 2012-2013 NgSql Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ng12306.ngsql.route.config;

/*-
 * @author:Fredric
 * @date: 2013-5-10
 */
public final class TableConfig {
	private String name;
	private String[] datanodes;
	private final TableRuleConfig rules;
	
	public TableConfig(String name, String datanodes,TableRuleConfig rule){
		this.name = name;
		this.rules = rule;
		this.datanodes = datanodes.split(",");
		if((this.datanodes == null)||(this.datanodes.length <= 0)){
			throw new IllegalArgumentException("TableConfig Argu Error:"+datanodes);
		}
	}

	public String getName() {
		return name;
	}

	public String[] getDataNodes() {
		return datanodes;
	}

	public TableRuleConfig getRules() {
		return rules;
	}
	
}
