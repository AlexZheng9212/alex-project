import { basename } from 'path'

export function shouldSkip(filename: string): boolean {
  const skipCase = process.env.SKIP_CASE || process.env.skip_case
  if (!skipCase) {
    return false
  }

  const specName = basename(filename).replace('.spec.ts', '')

  if (skipCase.split(',').includes(specName)) {
    return true
  }
  return false
}
