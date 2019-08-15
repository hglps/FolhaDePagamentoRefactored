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
| [UnionContract.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/strategy/UnionContract.java)     |  [UnionMember.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/strategy/UnionMember.java) , [NotUnionMember.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/strategy/NotUnionMember.java)  |   [Employee.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/companypackage/Employee.java) |

---

## Command
| Interface | Implementação | 
| ------------- | ------------- | 
| [ChoiceOperation.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/ChoiceOperation.java)     |  [CardUpdate.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/CardUpdate.java) , [ChangeRegister.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/ChangeRegister.java) , [DeleteEmployee.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/DeleteEmployee.java) , [InvalidChoice.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/InvalidChoice.java) , [NewEmployee.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/NewEmployee.java) , [NewSale.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/NewSale.java) , [Payroll.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/Payroll.java) , [ServiceFee.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/ServiceFee.java) , [ShowInfo.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/choicesmenufactory/ShowInfo.java)
|  [ChangeOperation.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/ChangeOperation.java)     |  [AddressChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/AddressChange.java) ,  [InvalidChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/InvalidChange.java) , [NameChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/NameChange.java) , [TypeChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/TypeChange.java) , [UnionChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/UnionChange.java) , [UnionFeeChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/UnionFeeChange.java) , [WayChange.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/registerfactory/WayChange.java)  |
|  [TypeOperation.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/TypeOperation.java)      | [AddCommissioned.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/AddCommissioned.java) , [AddHourly.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/AddHourly.java) , [AddSalaried.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/AddSalaried.java) , [InvalidType.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/InvalidType.java) , [ReturnCommissioned.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/ReturnCommissioned.java) , [ReturnHourly.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/ReturnHourly.java) , [ReturnSalaried.java](https://github.com/hglps/FolhaDePagamentoRefactored/blob/master/src/typemenufactory/ReturnSalaried.java)  | 

---


Info: **hlc2@ic.ufal.br**
         
