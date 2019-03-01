
/**
 * EstoqueBOProdutoNaoEncontradoExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package br.com.fiap.loja.bo;

public class EstoqueBOProdutoNaoEncontradoExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1551457753929L;
    
    private br.com.fiap.loja.bo.EstoqueBOStub.EstoqueBOProdutoNaoEncontradoException faultMessage;

    
        public EstoqueBOProdutoNaoEncontradoExceptionException() {
            super("EstoqueBOProdutoNaoEncontradoExceptionException");
        }

        public EstoqueBOProdutoNaoEncontradoExceptionException(java.lang.String s) {
           super(s);
        }

        public EstoqueBOProdutoNaoEncontradoExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public EstoqueBOProdutoNaoEncontradoExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(br.com.fiap.loja.bo.EstoqueBOStub.EstoqueBOProdutoNaoEncontradoException msg){
       faultMessage = msg;
    }
    
    public br.com.fiap.loja.bo.EstoqueBOStub.EstoqueBOProdutoNaoEncontradoException getFaultMessage(){
       return faultMessage;
    }
}
    