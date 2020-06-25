import Head from 'next/head'
import Link from 'next/link'
import styles from './index.module.scss'
const Links = (item: any) => (
  <Link href={item.name}>
    <div>{item.name}</div>
  </Link>
)
type GlobalHeaderProp = {
  navs: any[]
}
const GlobalHeader = (props: GlobalHeaderProp) => (
  <div className={styles.container}>
    <Head>
      <title>Alex's Blog</title>
    </Head>
    <div>{props.navs.map((item) => Links(item))}</div>
  </div>
)

export default GlobalHeader
