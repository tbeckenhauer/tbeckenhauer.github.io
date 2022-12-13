// const puppeteer = require('puppeteer');
// const fs = require('fs');


// (async() => {
//   const browser = await puppeteer.launch({headless:false});
//   console.log(await browser.version());
//   const page = await browser.newPage();
//   await page.goto('https://app.pluralsight.com/profile/thomas-beckenhauer', {waitUntil: 'networkidle2'});
//   const data = await page.evaluate(() => document.querySelector('*').outerHTML);
//   fs.writeFileSync('external_exports/pluralsight/profile.html', data);

//   const cssLinkHref = await page.evaluate(() => document.querySelector('link[href^="/profile/content/client/profile"]').href);
//   const cssPage = await browser.newPage();
//   await cssPage.goto(cssLinkHref, {waitUntil: 'networkidle2'})
//   const cssData = await cssPage.evaluate(() => document.querySelector('pre').innerHTML)
//   fs.writeFileSync('external_exports/pluralsight/profile.css', cssData);
// })();

'use strict';

const puppeteer = require('puppeteer');
const fs = require('fs');
const config = require('./config.json');

(async function main() {
  try {
    const browser = await puppeteer.launch({headless:false});
    const [page] = await browser.pages();

    for(const val of config.collection) {
      // console.log(val)
      await page.goto(val.url);
      const cdp = await page.target().createCDPSession();
      const { data } = await cdp.send('Page.captureSnapshot', { format: 'mhtml' });

      const dir = `./${val.site}`
      if (!fs.existsSync(dir)){
        fs.mkdirSync(dir, { recursive: true });
      }
      fs.writeFileSync(dir + '/profile.mhtml', data);
    }

    // await browser.close();
  } catch (err) {
    console.error(err);
  }
})();