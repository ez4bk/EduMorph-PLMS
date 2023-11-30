import { Base } from './base.model';
import { Teacher } from './teacher.model';
import { Subject } from './subject.model';

export interface SubjectTerm extends Base {
  name: string;
  description: string;
  startTime: Date;
  endTime: Date;
  teacher: Teacher;
  subject: Subject;
}
// function is a utility function that takes a SubjectTerm object as a parameter and returns a string representing the display information.
export function getSubjectTermDisplay(subjectTerm: SubjectTerm): string {
  if (!subjectTerm) return '';

  return subjectTerm.name;
}
