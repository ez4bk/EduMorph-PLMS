import { Base } from './base.model';
import { Teacher } from './teacher.model';
import { Subject } from './subject.model';

export interface SubjectNotification extends Base {
  name: string;
  description: string;
  publicationDate: Date;
  teacher: Teacher;
  subject: Subject;
}

//the display string is simply the name property of the subject notification. The getSubjectNotificationDisplay function incorporates a check to handle cases where the input subjectNotification is falsy, preventing potential errors.
export function getSubjectNotificationDisplay(
  subjectNotification: SubjectNotification
): string {
  if (!subjectNotification) return '';

  return subjectNotification.name;
}
