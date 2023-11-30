import { Base } from './base.model';
import { Subject } from './subject.model';
import { ExamType } from './exam-type.model';

export interface Exam extends Base {
  name: string;
  description: string;
  minimumScore: number;
  maximumScore: number;
  subject: Subject;
  examType: ExamType;
}
//function takes an Exam object as a parameter and returns a string representing the display information.
export function getExamDisplay(exam: Exam): string {
  if (!exam) return '';

  return `${exam.subject.name} - ${exam.name}`;
}

//function is another utility function that takes an Exam object as a parameter and returns a string representing the display information.
export function getExamNameDisplay(exam: Exam): string {
  if (!exam) return '';

  return `${exam.name}`;
}
