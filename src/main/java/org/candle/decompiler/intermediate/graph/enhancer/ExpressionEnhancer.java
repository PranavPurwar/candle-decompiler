package org.candle.decompiler.intermediate.graph.enhancer;

import org.apache.bcel.generic.ObjectType;
import org.apache.commons.lang.StringUtils;
import org.candle.decompiler.intermediate.code.StatementIntermediate;
import org.candle.decompiler.intermediate.expression.Expression;
import org.candle.decompiler.intermediate.expression.ASTListener;
import org.candle.decompiler.intermediate.expression.MethodInvocation;
import org.candle.decompiler.intermediate.expression.NewInstance;
import org.candle.decompiler.intermediate.graph.GraphIntermediateVisitor;
import org.candle.decompiler.intermediate.graph.context.IntermediateGraphContext;

public class ExpressionEnhancer extends GraphIntermediateVisitor {

	public ExpressionEnhancer(IntermediateGraphContext igc) {
		super(igc);
	}
	
	@Override
	public void visitStatementIntermediate(StatementIntermediate line) {
		Expression exp = line.getExpression();
		
		//ok, now we can visit the expression...
		exp.visit(new ASTListener() {
			
			@Override
			public void accept(Expression e) {
				if(e instanceof NewInstance) {
					if(((NewInstance) e).getType() instanceof ObjectType) {
						ObjectType obj = (ObjectType)((NewInstance) e).getType();
						if(StringUtils.equals("java.lang.StringBuilder", obj.getClassName())) {
							System.out.println(obj.getClassName());
						}
						
					}
				}
			}
		});
		
	}

}
