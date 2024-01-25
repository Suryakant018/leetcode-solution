# Write your MySQL query statement below
with emp_cte as
(select 
    id,
    name,
    salary,
    departmentId,
    dense_rank()over(partition by departmentId order by salary desc) as sal_rank
from Employee)
select 
    d.name as Department,
    e.name as Employee,
    e.Salary
from emp_cte e
inner join Department d on d.id = e.departmentID
where e.sal_rank = 1;
