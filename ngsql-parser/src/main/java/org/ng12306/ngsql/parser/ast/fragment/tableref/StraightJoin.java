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
package org.ng12306.ngsql.parser.ast.fragment.tableref;

import org.ng12306.ngsql.parser.ast.expression.Expression;
import org.ng12306.ngsql.parser.visitor.SQLASTVisitor;


/**
 * 
* [添加说明]
* @author: <a href="mailto:lvbomr@gmail.com">lvbo</a>
* @date: 2013-5-26 上午11:35:21
* @version: 1.0
 */
public class StraightJoin implements TableReference {
    private final TableReference leftTableRef;
    private final TableReference rightTableRef;
    private Expression onCond;

    public StraightJoin(TableReference leftTableRef, TableReference rightTableRef, Expression onCond) {
        super();
        this.leftTableRef = leftTableRef;
        this.rightTableRef = rightTableRef;
        this.onCond = onCond;
    }

    public StraightJoin(TableReference leftTableRef, TableReference rightTableRef) {
        this(leftTableRef, rightTableRef, null);
    }

    public TableReference getLeftTableRef() {
        return leftTableRef;
    }

    public TableReference getRightTableRef() {
        return rightTableRef;
    }

    public Expression getOnCond() {
        return onCond;
    }

    @Override
    public Object removeLastConditionElement() {
        if (onCond != null) {
            Object obj = onCond;
            onCond = null;
            return obj;
        }
        return null;
    }

    @Override
    public boolean isSingleTable() {
        return false;
    }

    @Override
    public int getPrecedence() {
        return TableReference.PRECEDENCE_JOIN;
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

}
