import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject
import groovy.json.JsonSlurper

// 1. Bertindak sebagai PRODUCER: Mengirimkan data baru via POST
ResponseObject postResponse = WS.sendRequest(findTestObject('Object Repository/POST_Create_Post'))
WS.verifyResponseStatusCode(postResponse, 201)

// Ambil ID yang digenerate otomatis oleh server dari response body
JsonSlurper slurper = new JsonSlurper()
def jsonResponse = slurper.parseText(postResponse.getResponseBodyContent())
def dynamicId = jsonResponse.id.toString()

// 2. Bertindak sebagai CONSUMER: Mengambil & memvalidasi data berdasarkan ID tadi via GET
// Karena jsonplaceholder adalah mock API, data 101 tidak benar-benar tersimpan, kita simulasikan membaca ID '1' yang valid
ResponseObject getResponse = WS.sendRequest(findTestObject('Object Repository/GET_by_ID', [('id') : '1']))

// Asersi Validasi Konten
WS.verifyResponseStatusCode(getResponse, 200)
WS.verifyElementPropertyValue(getResponse, 'userId', 1)