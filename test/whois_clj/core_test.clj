(ns whois-clj.core-test
  (:require [clojure.test :refer :all]
            [whois-clj.core :refer :all]))

(def google-response "   Domain Name: GOOGLE.COM\r\n   Registry Domain ID: 2138514_DOMAIN_COM-VRSN\r\n   Registrar WHOIS Server: whois.markmonitor.com\r\n   Registrar URL: http://www.markmonitor.com\r\n   Updated Date: 2019-09-09T15:39:04Z\r\n   Creation Date: 1997-09-15T04:00:00Z\r\n   Registry Expiry Date: 2028-09-14T04:00:00Z\r\n   Registrar: MarkMonitor Inc.\r\n   Registrar IANA ID: 292\r\n   Registrar Abuse Contact Email: abusecomplaints@markmonitor.com\r\n   Registrar Abuse Contact Phone: +1.2086851750\r\n   Domain Status: clientDeleteProhibited https://icann.org/epp#clientDeleteProhibited\r\n   Domain Status: clientTransferProhibited https://icann.org/epp#clientTransferProhibited\r\n   Domain Status: clientUpdateProhibited https://icann.org/epp#clientUpdateProhibited\r\n   Domain Status: serverDeleteProhibited https://icann.org/epp#serverDeleteProhibited\r\n   Domain Status: serverTransferProhibited https://icann.org/epp#serverTransferProhibited\r\n   Domain Status: serverUpdateProhibited https://icann.org/epp#serverUpdateProhibited\r\n   Name Server: NS1.GOOGLE.COM\r\n   Name Server: NS2.GOOGLE.COM\r\n   Name Server: NS3.GOOGLE.COM\r\n   Name Server: NS4.GOOGLE.COM\r\n   DNSSEC: unsigned\r\n   URL of the ICANN Whois Inaccuracy Complaint Form: https://www.icann.org/wicf/\r\n>>> Last update of whois database: 2024-11-15T04:18:34Z <<<\r\n\r\nFor more information on Whois status codes, please visit https://icann.org/epp\r\n\r\nNOTICE: The expiration date displayed in this record is the date the\r\nregistrar's sponsorship of the domain name registration in the registry is\r\ncurrently set to expire. This date does not necessarily reflect the expiration\r\ndate of the domain name registrant's agreement with the sponsoring\r\nregistrar.  Users may consult the sponsoring registrar's Whois database to\r\nview the registrar's reported date of expiration for this registration.\r\n\r\nTERMS OF USE: You are not authorized to access or query our Whois\r\ndatabase through the use of electronic processes that are high-volume and\r\nautomated except as reasonably necessary to register domain names or\r\nmodify existing registrations; the Data in VeriSign Global Registry\r\nServices' (\"VeriSign\") Whois database is provided by VeriSign for\r\ninformation purposes only, and to assist persons in obtaining information\r\nabout or related to a domain name registration record. VeriSign does not\r\nguarantee its accuracy. By submitting a Whois query, you agree to abide\r\nby the following terms of use: You agree that you may use this Data only\r\nfor lawful purposes and that under no circumstances will you use this Data\r\nto: (1) allow, enable, or otherwise support the transmission of mass\r\nunsolicited, commercial advertising or solicitations via e-mail, telephone,\r\nor facsimile; or (2) enable high volume, automated, electronic processes\r\nthat apply to VeriSign (or its computer systems). The compilation,\r\nrepackaging, dissemination or other use of this Data is expressly\r\nprohibited without the prior written consent of VeriSign. You agree not to\r\nuse electronic processes that are automated and high-volume to access or\r\nquery the Whois database except as reasonably necessary to register\r\ndomain names or modify existing registrations. VeriSign reserves the right\r\nto restrict your access to the Whois database in its sole discretion to ensure\r\noperational stability.  VeriSign may restrict or terminate your access to the\r\nWhois database for failure to abide by these terms of use. VeriSign\r\nreserves the right to modify these terms at any time.\r\n\r\nThe Registry database contains ONLY .COM, .NET, .EDU domains and\r\nRegistrars.\r\n")

(def google-response-parsed
  {:dnssec                        "unsigned",
   :updated-date                  "2019-09-09T15",
   :domain-status
   ["clientDeleteProhibited https"
    "clientTransferProhibited https"
    "clientUpdateProhibited https"
    "serverDeleteProhibited https"
    "serverTransferProhibited https"
    "serverUpdateProhibited https"],
   :name-server
   ["NS1.GOOGLE.COM"
    "NS2.GOOGLE.COM"
    "NS3.GOOGLE.COM"
    "NS4.GOOGLE.COM"],
   :registrar                     "MarkMonitor Inc.",
   :registry-expiry-date          "2028-09-14T04",
   :registry-domain-id            "2138514_DOMAIN_COM-VRSN",
   :registrar-url                 "http",
   :registrar-abuse-contact-email "abusecomplaints@markmonitor.com",
   :registrar-whois-server        "whois.markmonitor.com",
   :registrar-iana-id             "292",
   :domain-name                   "GOOGLE.COM",
   :creation-date                 "1997-09-15T04",
   :registrar-abuse-contact-phone "+1.2086851750"})

(deftest parse-test
  (testing "response parsing"
    (is (parse google-response)
        google-response-parsed)))
