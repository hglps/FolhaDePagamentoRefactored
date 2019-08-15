# FolhaDePagamentoRefactored

## Projeto Refatoramento - Folha de Pagamento

Utilização inicial -> Igual ao do projeto OO, do diretório [FolhaDePagamentoOO](https://github.com/hglps/FolhaDePagamentoOO/) , 
no entanto, a entrada é por uma string descrevendo a funcionalidade desejada.

# Padrões de projeto utilizados

## Factory
| Implementação | Utilização|
| ------------- | ----------- | 
|  [ChoiceFactory.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/ChoiceFactory.java)    |  [NewEmployee.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/NewEmployee.java) |
|   [ChangeRegisterFactory.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/ChangeRegisterFactory.java) |  [Headmaster.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/main/HeadMaster.java) |
|   [TypeEmployeeFactory.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/TypeEmployeeFactory.java) | [TypeChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/TypeChange.java) |
| | [ChangeRegister.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/ChangeRegister.java) |

---

## Visitor
| Interface | Implementação |  Utilização |
| ------------- | ------------- | ------------- |
|  [Visitor.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/visitor/Visitor.java) , [Visitable.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/visitor/Visitable.java)    |  [CalculateSalaryVisitor.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/visitor/CalculateSalaryVisitor.java)   |   [Headmaster.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/main/HeadMaster.java)|
|     |  [Hourly.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/companypackage/Hourly.java) , [Commissioned.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/companypackage/Commissioned.java) , [Salaried.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/companypackage/Salaried.java)   |   

---

## Interpreter
| Interface | Implementação |  Utilização |
| ------------- | ------------- | ------------- |
|  [Specification.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/interpreter/Specification.java)    |  [NewSaleSpec.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/interpreter/NewSaleSpec.java) , [NewServiceFeeSpec.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/interpreter/NewServiceFeeSpec.java) , [PartOfUnion.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/interpreter/PartOfUnion.java)  |   [NewSale.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/NewSale.java) |
|     |    |  [UnionFeeChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/UnionFeeChange.java) |

---

## Strategy
| Interface | Implementação |  Utilização |
| ------------- | ------------- | ------------- |
| strategy/UnionContract.java     |  strategy/(UnionMember.java ; NotUnionMember.java)  |   companypackage/Employee.java |

---

## Command
| Interface | Implementação | 
| ------------- | ------------- | 
| choicemenusfactory/ChoiceOperation.java     |  choicemenusfactory/(CardUpdate.java ; ChangeRegister.java ; DeleteEmployee.java ; InvalidChoice.java ; NewEmployee.java ; NewSale.java ; Payroll.java ; ServiceFee.java ; ShowInfo.java ; )
|  registerfactory/ChangeOperation.java     |  registerfactory/ (AddressChange.java ;  InvalidChange.java ; NameChange.java ; TypeChange.java ; UnionChange.java ; UnionFeeChange.java ; WayChange.java)  |
|  typemenufactory/TypeOperation.java      | typemenufactory/ (AddCommissioned.java ; AddHourly.java ; AddSalaried.java ; InvalidType.java ; ReturnCommissioned.java; ReturnHourly.java; ReturnSalaried.java)  | 

---


Info: **hlc2@ic.ufal.br**
         
