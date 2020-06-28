import { CountryPhoneCode } from './constant'

interface Pagination {
  offset: number
  limit: number
}

export function getPagination(skip?: string, limit?: string): Pagination {
  const p = {
    offset: parseInt(skip || ''),
    limit: parseInt(limit || ''),
  }
  if (!(p.offset >= 0)) {
    p.offset = 0
  }
  if (!(p.limit >= 0)) {
    p.limit = 20
  }
  return p
}

export function trimPhoneNumber(phoneNumber: string): string {
  return phoneNumber.trim().replace(/^\+/, '')
}

export function hidePhoneNumber(phoneNumber?: string | number): string {
  const s =
    String(phoneNumber || '')
      .split('-')
      .pop() || ''
  const arr = s.split('')
  const start = arr.slice(0, 3).join('')
  const end = arr.slice(arr.length - 4, arr.length).join('')
  return start + '****' + end
}

export function isNumber(s: string): boolean {
  return /^\d+$/.test(s)
}

interface ValidPhoneNumber {
  isValid: boolean
  validPhone: string
}

export function phoneNumberValidor(phoneNumber: string): ValidPhoneNumber {
  const arr = String(phoneNumber).split('-')
  const validPhone = arr.length > 1 ? arr[1] : phoneNumber
  const isValid = validatePhoneNumberStrategy(arr)
  return { isValid, validPhone }
}

/**
 * private methods
 */

function validatePhoneNumberStrategy(arr: any): boolean {
  let isValid = false
  switch (arr[0]) {
    case CountryPhoneCode.CN:
      isValid =
        isNumber(arr[0]) &&
        isNumber(arr[1]) &&
        arr[1].length > 7 &&
        arr[1].length < 12
      break
    case CountryPhoneCode.CNHK:
    case CountryPhoneCode.CNMC:
    case CountryPhoneCode.CNTW:
      isValid = isNumber(arr[0]) && isNumber(arr[1]) && arr[1].length === 8
      break
    default:
      console.warn('Unknown phone number')
  }
  return isValid
}
