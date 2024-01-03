# Write your MySQL query statement below
With q as 

(
    select e.name m_name, e.salary m_salary, 
d.name as department,

Dense_rank() over(partition by d.name order by salary DESC) r

from employee e inner join Department d on
e.departmentId = d.id order by d.name ASC, e.salary DESC
)

select department Department, m_name Employee, m_salary Salary from q where r in (1,2,3);