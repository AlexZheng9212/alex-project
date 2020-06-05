import {
  trimPhoneNumber,
  hidePhoneNumber,
  phoneNumberValidor,
  isNumber,
  getPagination,
} from '../src'
describe('Kit', () => {
  it('isNumber', () => {
    expect(isNumber('12345678910')).toEqual(true)
  })
  it('trimPhoneNumber', () => {
    expect(trimPhoneNumber('86-123456')).toEqual('86-123456')
    expect(trimPhoneNumber('+86-123456 ')).toEqual('86-123456')
    expect(trimPhoneNumber(' 86-123456 ')).toEqual('86-123456')
    expect(trimPhoneNumber(' 86 123456 ')).toEqual('86 123456')
    expect(trimPhoneNumber('+86 123456 ')).toEqual('86 123456')
  })

  it('hidePhoneNumber', () => {
    expect(hidePhoneNumber('86-12345678910')).toEqual('123****8910')
    expect(hidePhoneNumber('86-18910')).toEqual('189****8910')
    expect(hidePhoneNumber()).toEqual('****')
  })

  it('phoneNumberValidor', () => {
    expect(phoneNumberValidor('86-12345678910')).toEqual({
      isValid: true,
      validPhone: '12345678910',
    })
    expect(phoneNumberValidor('852-12345678')).toEqual({
      isValid: true,
      validPhone: '12345678',
    })
    expect(phoneNumberValidor('852-12345678910')).toEqual({
      isValid: false,
      validPhone: '12345678910',
    })
    expect(phoneNumberValidor('853-12345678')).toEqual({
      isValid: true,
      validPhone: '12345678',
    })
    expect(phoneNumberValidor('853-12345678910')).toEqual({
      isValid: false,
      validPhone: '12345678910',
    })
    expect(phoneNumberValidor('886-12345678')).toEqual({
      isValid: true,
      validPhone: '12345678',
    })
    expect(phoneNumberValidor('886-12345678910')).toEqual({
      isValid: false,
      validPhone: '12345678910',
    })
    expect(phoneNumberValidor('666-12345678')).toEqual({
      isValid: false,
      validPhone: '12345678',
    })
  })
  it('getPagination', () => {
    expect(getPagination('5', '15')).toEqual({ offset: 5, limit: 15 })
    expect(getPagination('5', '-2')).toEqual({ offset: 5, limit: 20 })
    expect(getPagination('-9', '15')).toEqual({ offset: 0, limit: 15 })
    expect(getPagination('-5', '-15')).toEqual({ offset: 0, limit: 20 })
  })
})
