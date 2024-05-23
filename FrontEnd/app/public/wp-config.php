<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the installation.
 * You don't have to use the web site, you can copy this file to "wp-config.php"
 * and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * Database settings
 * * Secret keys
 * * Database table prefix
 * * Localized language
 * * ABSPATH
 *
 * @link https://wordpress.org/support/article/editing-wp-config-php/
 *
 * @package WordPress
 */

// ** Database settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'local' );

/** Database username */
define( 'DB_USER', 'root' );

/** Database password */
define( 'DB_PASSWORD', 'root' );

/** Database hostname */
define( 'DB_HOST', 'localhost' );

/** Database charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8' );

/** The database collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication unique keys and salts.
 *
 * Change these to different unique phrases! You can generate these using
 * the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}.
 *
 * You can change these at any point in time to invalidate all existing cookies.
 * This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',          'mV^M5kmk28LjMu+WW&c],nYJBlxk,SB$x.P)|Y|3j[~}H}uvcw})x;@_PB/DofwG' );
define( 'SECURE_AUTH_KEY',   '@_5,h)n;:AB1P}pJz<#03(.$<2JvY:>>>sJRWb7b+@y>dfN7B/E&j!t<@-os-opj' );
define( 'LOGGED_IN_KEY',     '3V=kxCkS#p{)aq?d[{,qo|;uTkcTK4*7=Z|#):QLFRD2egry>2$D:k(w-Fq_~y4n' );
define( 'NONCE_KEY',         'SH++@$37<yV4XY`+Lmr$|<<|6|=R 7b9Dcw#Q ib^G$pmvz0k%hV^@BnK1TGpkn|' );
define( 'AUTH_SALT',         '$bZTy m@Bz`oa9ogzk*;(pfOLY~?W$S%^$u)aX.=I (0{ZXi(6R<>VP[G2Et*gIw' );
define( 'SECURE_AUTH_SALT',  ']aVb<Tq1Ni5pNC@lJQ>zS4Id*NKdL>Awy4!%Lv+VINtnSe&eE4B0i_l,Hp?.bSkH' );
define( 'LOGGED_IN_SALT',    '2]|[K0^e(J|nn/0eLgS$5s?ZJR:~[fw5n]}=mz.*be/JfOiGdvX/q/.4YcKy0Mw,' );
define( 'NONCE_SALT',        'g7JaYuzr9_N1ym9^I.gSiK}B==6U.l>; ;6bjMRY$Y*;?kD9_&8w>yZ?$FsUYNRy' );
define( 'WP_CACHE_KEY_SALT', '@1} u[}Z7fy4y.F=,eW_so5.,U#hD;+zAZc4ndXiJe*qV]7{1H;e)<[pY. w4tC7' );


/**#@-*/

/**
 * WordPress database table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'wp_';


/* Add any custom values between this line and the "stop editing" line. */



/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://wordpress.org/support/article/debugging-in-wordpress/
 */
if ( ! defined( 'WP_DEBUG' ) ) {
	define( 'WP_DEBUG', false );
}

define( 'WP_ENVIRONMENT_TYPE', 'local' );
/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';
