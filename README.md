# FolhaDePagamentoRefactored

Projeto Refatoramento - Folha de Pagamento

**Utilização inicial** : Igual ao do projeto OO, do diretório [FolhaDePagamentoOO](https://github.com/hglps/FolhaDePagamentoOO/) , 
no entanto, a entrada é por uma string descrevendo a funcionalidade desejada.

**PADRÕES DE PROJETO UTILIZADOS E SUAS RESPECTIVAS CLASSES:**

* Factory : **choicemenusfactory/ChoiceFactory.java ; registerfactory/ChangeRegisterFactory.java ; typemenufactory/TypeEmployeeFactory.java**

* Command : **interface choicemenusfactory/ChoiceOperation.java implementada em choicemenusfactory/
(CardUpdate.java ; ChangeRegister.java ; DeleteEmployee.java ; InvalidChoice.java ; NewEmployee.java ; 
NewSale.java ; Payroll.java ; ServiceFee.java ; ShowInfo.java ; )**

**interface registerfactory/ChangeOperation.java implementada em registerfactory/ (	AddressChange.java ;  InvalidChange.java ; NameChange.java ; TypeChange.java ; UnionChange.java ; UnionFeeChange.java ; WayChange.java)**

**interface typemenufactory/TypeOperation.java implementada em typemenufactory/ (   	AddCommissioned.java ;
	AddHourly.java 	;
	AddSalaried.java 	;
	InvalidType.java 	;
	ReturnCommissioned.java	;
	ReturnHourly.java 	;
	ReturnSalaried.java)**
  
* Visitor : **interfaces visitor/(Visitor.java ; Visitable.java) implementadas em visitor/CalculateSalaryVisitor.java e nas classes companypackage/(Hourly.java ; Commissioned.java ; Salaried.java) usada na classe main/Headmaster.java**

* Interpreter : **interface interpreter/Specification.java implementada nas classes interpreter/(NewSaleSpec.java ; NewServiceFeeSpec.java ; PartOfUnion.java) usada em choicemenufactory/NewSale.java e registerfactory/UnionFeeChange.java**

* Strategy : **interface strategy/UnionContract.java implementada em strategy/(UnionMember.java ; NotUnionMember.java) e usada em companypackage/Employee.java**



Info: **hlc2@ic.ufal.br**
