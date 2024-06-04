const http = require('http');
const url = require('url');
const escapeHtml = (unsafe) => {
    return unsafe
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
};

http.createServer((req, res) => {
    const queryObject = url.parse(req.url, true).query;
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end(`<h1>${escapeHtml(queryObject.user)}</h1>`);
}).listen(8080);

console.log('Server running at http://127.0.0.1:8080/');
