const baseURL = process.env.VUE_APP_BASE_API
const zlService = {
  baseUrl: baseURL + '/sys-admin-service',
  oauthUrl: baseURL + '/sys-uua',
  seqUrl: baseURL + '/sys-sequence-service'
}
export default zlService
