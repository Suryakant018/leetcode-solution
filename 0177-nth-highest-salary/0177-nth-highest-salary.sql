create function getNthHighestSalary(p_rank Integer) Returns Integer
begin 
    Declare var_salary Integer;
    
    select 
        max(T.salary)
    into 
        var_salary
    from 
    (
    select 
        *,
        dense_rank() over(order by salary desc) as ranking
    from 
        Employee
    ) as T
    where 
        T.ranking = p_rank; 

    Return var_salary;
end;