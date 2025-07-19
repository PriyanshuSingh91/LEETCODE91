# Write your MySQL query statement below

SELECT a1.name AS 'Employee'
FROM Employee a1
LEFT JOIN Employee a2
ON a1.managerId = a2.id
WHERE a1.salary > a2.salary;