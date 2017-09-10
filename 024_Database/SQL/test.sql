select cName, state,
(select distinct GPA
from Apply, Student
where College.cName = Apply.cName
and Apply.sID = Student.sID
and GPA >= (select max(GPA) from Student, Apply
where Student.sID = Apply.sID
and Apply.cName = College.cName)) as GPA
from College;