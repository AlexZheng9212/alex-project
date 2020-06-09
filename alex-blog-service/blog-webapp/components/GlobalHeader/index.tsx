import Head from 'next/head'
import Link from 'next/link'
import navs from '../../fixture/nav.json'
import styles from './index.module.scss'
const Links = (item: any) => (
  <Link href={item.name}>
    <div>{item.name}</div>
  </Link>
)
const GlobalHeader = () => (
  <div className={styles.container}>
    <div>
      <Head>
        <title>Blog</title>
      </Head>
      <div>{navs.map((item) => Links(item))}</div>
    </div>
  </div>
)

export default GlobalHeader
