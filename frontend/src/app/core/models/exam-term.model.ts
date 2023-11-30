import { Base } from './base.model';
import { ExamPeriod, getExamPeriodDisplay } from './exam-period.model';
import { Exam, getExamDisplay, getExamNameDisplay } from './exam.model';

export interface ExamTerm extends Base {
  startTime: Date;
  endTime: Date;
  exam: Exam;
  examPeriod: ExamPeriod;
}
// provide a way to get formatted display strings for ExamTerm objects.
// function is a utility function that takes an ExamTerm object as a parameter and returns a string representing the display information.
export function getExamTermDisplay(examTerm: ExamTerm): string {
  if (!examTerm) return '';
  //if the examTerm is falsy (e.g., null or undefined), and if so, it returns an empty string.
  return `${getExamDisplay(examTerm.exam)} - ${getExamPeriodDisplay(
    examTerm.examPeriod
  )}`;
}
//function is another utility function that takes an ExamTerm object as a parameter and returns a string representing the display information.
export function getExamTermWithoutSubjectDisplay(examTerm: ExamTerm): string {
  if (!examTerm) return '';

  return `${getExamNameDisplay(examTerm.exam)} - ${getExamPeriodDisplay(
    examTerm.examPeriod
  )}`;
}
