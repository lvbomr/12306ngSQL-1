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
package org.ng12306.ngsql.parser.ast.expression.primary.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ng12306.ngsql.parser.ast.expression.Expression;
import org.ng12306.ngsql.parser.ast.expression.primary.PrimaryExpression;
import org.ng12306.ngsql.parser.visitor.SQLASTVisitor;



/**
 * 
* [添加说明]
* @author: <a href="mailto:lvbomr@gmail.com">lvbo</a>
* @date: 2013-5-26 上午7:39:58
* @version: 1.0
 */
public abstract class FunctionExpression extends PrimaryExpression {
    protected static List<Expression> wrapList(Expression expr) {
        List<Expression> list = new ArrayList<Expression>(1);
        list.add(expr);
        return list;
    }

    /**
     * <code>this</code> function object being called is a prototype
     */
    public abstract FunctionExpression constructFunction(List<Expression> arguments);

    protected final String functionName;
    protected final List<Expression> arguments;

    public FunctionExpression(String functionName, List<Expression> arguments) {
        super();
        this.functionName = functionName;
        if (arguments == null || arguments.isEmpty()) {
            this.arguments = Collections.emptyList();
        } else {
            if (arguments instanceof ArrayList) {
                this.arguments = arguments;
            } else {
                this.arguments = new ArrayList<Expression>(arguments);
            }
        }
    }

    public void init() {
    }

    /**
     * @return never null
     */
    public List<Expression> getArguments() {
        return arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    @Override
    public Expression setCacheEvalRst(boolean cacheEvalRst) {
        return super.setCacheEvalRst(cacheEvalRst);
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
