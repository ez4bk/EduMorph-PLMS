import { Base } from './base.model';
import { Teacher } from './teacher.model';
import { Subject } from './subject.model';

export interface SubjectMaterial extends Base {
  name: string;
  description: string;
  resourceUrl: string;
  publicationDate: Date;
  teacher: Teacher;
  subject: Subject;
}

export function getSubjectMaterialDisplay(
  //function incorporates a check to handle cases where the input subjectMaterial is falsy, preventing potential errors.
  subjectMaterial: SubjectMaterial
): string {
  if (!subjectMaterial) return '';

  return subjectMaterial.name;
}
