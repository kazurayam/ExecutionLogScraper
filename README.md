# ExecutionLogScraper

A Katalon Studio project that includes a custom keyword named `com.kazurayam.ksbackyard.ExecutionLogScraper`.

The class implements a method `public NodeList findRecordWithAttachement(String attachement)` that scans through a `execution0.log` file in a Report folder to look up a `<record>` Element that contains the screenshot PNG file that was taken by the "take screenshot on built-in keyword failure" feature.


