context App 
inv : self.gender="Male" and self.age>55 implies self.status="DECLINED"
inv : self.gender="Female" and self.age>57 implies self.status="DECLINED"
inv : self.password.size()>9  implies self.status="ACCEPTED"
inv : self.gender="Female"  implies self.status="INVITED" and self.note->notEmpty()
inv : self.status="INVITED" implies self.note->isEmpty()
inv: self.allInstances()-> select( status="ACCEPTED") -> size()=199 and self.gender="Male" and self.age=54 implies self.status="ACCEPTED"
inv: self.allInstances()-> select( status="ACCEPTED") -> size()=200 and self.gender="Male" and self.age=54 implies self.status="PENDING"