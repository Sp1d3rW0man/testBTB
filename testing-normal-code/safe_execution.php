<?php
if (isset($_GET['cmd'])) {
    $whitelist = ['ls', 'whoami'];
    $cmd = $_GET['cmd'];
    if (in_array($cmd, $whitelist)) {
        system($cmd);
    } else {
        echo "Command not allowed.";
    }
}
?>
