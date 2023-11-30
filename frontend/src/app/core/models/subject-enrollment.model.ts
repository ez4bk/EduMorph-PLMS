import { Base } from './base.model';
import { getStudentDisplay, Student } from './student.model';
import { getSubjectDisplay, Subject } from './subject.model';

export interface SubjectEnrollment extends Base {
  student: Student;
  subject: Subject;
  extraPoints: number;
  grade: number;
}
// displaying information about SubjectEnrollment objects. They handle cases where the input subjectEnrollment is falsy,
//returning an empty string to prevent potential errors. The actual display information for students and subjects is obtained by calling other functions (getStudentDisplay and getSubjectDisplay),
export function getSubjectEnrollmentDisplay(
  subjectEnrollment: SubjectEnrollment
): string {
  if (!subjectEnrollment) return '';

  return `${getStudentDisplay(subjectEnrollment.student)} - ${getSubjectDisplay(
    subjectEnrollment.subject
  )}`;
}

export function getSubjectEnrollmentStudentDisplay(
  subjectEnrollment: SubjectEnrollment
): string {
  if (!subjectEnrollment) return '';

  return getStudentDisplay(subjectEnrollment.student);
}

export function getSubjectEnrollmentSubjectDisplay(
  subjectEnrollment: SubjectEnrollment
): string {
  if (!subjectEnrollment) return '';

  return getSubjectDisplay(subjectEnrollment.subject);
}
